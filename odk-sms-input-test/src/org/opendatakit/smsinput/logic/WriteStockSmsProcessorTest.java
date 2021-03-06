package org.opendatakit.smsinput.logic;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.opendatakit.common.android.utilities.ODKDatabaseUtils;
import org.opendatakit.smsinput.model.ModelConverter;
import org.opendatakit.smsinput.model.OdkSms;
import org.opendatakit.smsinput.persistence.StockMessageAccessor;
import org.opendatakit.smsinput.util.TestUtil;
import org.robolectric.RobolectricTestRunner;

import android.database.sqlite.SQLiteDatabase;

/**
 * @author sudar.sam@gmail.com
 *
 */
@RunWith(RobolectricTestRunner.class)
public class WriteStockSmsProcessorTest {
    
  WriteStockMessageProcessor processor;
  
  StockMessageAccessor mockAccessor;
  
  @Before
  public void before() {
    this.mockAccessor = mock(StockMessageAccessor.class);
    
    processor = new WriteStockMessageProcessor(this.mockAccessor);
    
  }
  
  @Test
  public void processSmsMessagesCallsHandleMessage() {
    
    List<OdkSms> messages = TestUtil.getTestOdkSmsMessages();
    
    // Stub out the call to handle message, just to make sure that it gets
    // invoked.
    this.processor = spy(this.processor);
    
    doNothing().when(this.processor).handleSms(messages.get(0));
    doNothing().when(this.processor).handleSms(messages.get(1));
    
    this.processor.processSmsMessages(messages);
    
    // Should handle each message once
    verify(this.processor, times(1)).handleSms(messages.get(0));
    verify(this.processor, times(1)).handleSms(messages.get(1));
    
    // And try to catch any changes to the test object for sanity
    verify(this.processor, times(2)).handleSms(any(OdkSms.class));
    
  }
  
  

}
