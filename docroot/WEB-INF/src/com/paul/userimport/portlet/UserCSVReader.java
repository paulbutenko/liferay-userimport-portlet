package com.paul.userimport.portlet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.supercsv.cellprocessor.ParseBool;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.paul.userimport.portlet.model.UserBean;


public class UserCSVReader {
  /** The Constant LOGGER. */
  private static final Logger LOGGER = Logger.getLogger(UserCSVReader.class);
  
  /** Singleton instance. */
  private static UserCSVReader INSTANCE = new UserCSVReader();

  private UserCSVReader() {
  }

  public static UserCSVReader getInstance() {
    return INSTANCE;
  }

  final CellProcessor[] processors = new CellProcessor[] {null, null, null, null, null, new ParseBool()};

  public List<UserBean> readUsers() {
    ICsvBeanReader inFile = null;
    List<UserBean> users = new ArrayList<UserBean>();
    try {
      inFile = new CsvBeanReader(new FileReader(FileUtils.toFile(this.getClass()
          .getResource("/users.csv"))), CsvPreference.EXCEL_NORTH_EUROPE_PREFERENCE);

      final String[] header = inFile.getCSVHeader(true);

      LOGGER.info("Reading users with properties: " + Arrays.toString(header) + " from CSV file.");
      UserBean user;
      while ((user = inFile.read(UserBean.class, header, processors)) != null) {
        users.add(user);
      }
      LOGGER.info(users.size() + " users were read from CSV file.");
    } catch (FileNotFoundException fnfe) {
      LOGGER.error("Can't find CSV file with users " + fnfe);
    } catch (IOException ioe) {
      LOGGER.error("IOException " + ioe);
    } finally {
      try {
        inFile.close();
      } catch (IOException e) {
      }
    }

    return users;

  }
}
