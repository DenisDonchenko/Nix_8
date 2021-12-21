package ua.com.alevel;


import ua.com.alevel.finding.way.FindingWay;
import ua.com.alevel.list.date.DateLIst;
import ua.com.alevel.unique.name.UniqueNames;
import ua.com.alevel.util.ConstGlobal;
import ua.com.alevel.util.FileHelper;

public class ModuleMain {
    public static void main(String[] args) {
      /*  FileHelper.clearFiles(ConstGlobal.PATH_TO_FILE_FINDING_WAY_OUTPUT,
                ConstGlobal.PATH_TO_FILE_LIST_DATES_OUTPUT,
                ConstGlobal.PATH_TO_FILE_UNIQUE_NAME_OUTPUT);*/
        new DateLIst().run();
        new UniqueNames().run();
        FindingWay findingWay = new FindingWay();
        findingWay.run();



    }
}
