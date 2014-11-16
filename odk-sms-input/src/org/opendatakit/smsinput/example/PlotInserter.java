package org.opendatakit.smsinput.example;

import org.opendatakit.common.android.utilities.ODKDatabaseUtils;
import org.opendatakit.smsinput.api.AbsTableInserter;
import org.opendatakit.smsinput.api.ITableDefinition;

import android.database.sqlite.SQLiteDatabase;

public class PlotInserter extends AbsTableInserter {

  public PlotInserter(
      ODKDatabaseUtils dbUtil,
      SQLiteDatabase appDatabase,
      String appId,
      ITableDefinition tableDefinition) {
    super(dbUtil, appDatabase, appId, tableDefinition);

  }

}