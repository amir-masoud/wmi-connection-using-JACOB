package com.company;
import com.jacob.activeX.*;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComFailException;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ActiveXComponent wmi = new ActiveXComponent("WbemScripting.SWbemLocator");
        Variant[] variantParameters = new Variant[4];
        variantParameters[0] = new Variant("192.168.0.1");
        variantParameters[1] = new Variant("root\\MicrosoftDNS"); //cimv2//MicrosoftDNS
        variantParameters[2] = new Variant("Administrator");
        variantParameters[3] = new Variant("1234Aa#");
        Variant conRet = wmi.invoke("ConnectServer", variantParameters);
        ActiveXComponent wmiconect = new ActiveXComponent(conRet.toDispatch());
        String excuttingQuery = "";
        String query1 = "select CategoryString, Message, TimeGenerated, User, Type from Win32_NtLogEvent where Logfile = 'Application' and TimeGenerated > '20070915000000.000000-***'";
        String query2 = "SELECT * FROM Win32_NetworkAdapterConfiguration";
        String query3 = "SELECT * FROM CIM_Action";
        String query4 = "SELECT * FROM Win32_OperatingSystem";
        String query5 = "SELECT * FROM CIM_Chip";
        String query6 = "shutdown -s -t5";
        String query7 = String.format("select * from MicrosoftDNS_AType where OwnerName ='www.msd.com' ","www","msd.com");
        String query8 = "select * from MicrosoftDNS_AType ";
        String[] ss = {""};
        //
        excuttingQuery = query7;
        //

        System.out.println(excuttingQuery);
        Variant vCollection = wmiconect.invoke("ExecQuery", new Variant(excuttingQuery));//ExecQuery
        EnumVariant enumVariant = new EnumVariant(vCollection.toDispatch());
        Reciver myReciver = new Reciver();
        //showing resualt of the query
        if (excuttingQuery == query4){
            myReciver.resultOf_Win32_OperatingSystem(enumVariant);
        }//end if(excuttingQuery == query4)
        else if (excuttingQuery == query3){
            myReciver.resultOf_CIM_Action(enumVariant);
        }//end else if (excuttingQuery == query3)
        else if(excuttingQuery == query5){
            myReciver.resultOf_CIM_Chip(enumVariant);
        }//end else if(excuttingQuery == query5)
        else if(excuttingQuery==query7||excuttingQuery==query8){
            myReciver.resultOf_MicrosoftDNS_AType(enumVariant,wmiconect);
        }//end of else if(excuttingQuery==query7
        else{
            System.out.println("wrong query");
        }//end else

        System.out.println("salam");

    }//end of public static voi main



}// end of public class Main














//        Dispatch item = null;
//        while (enumVariant.hasMoreElements()){
//            item = enumVariant.Next().toDispatch();
//            String categoryString = Dispatch.call(item,"categoryString ").toString();
//            String timeGenerated = Dispatch.call(item,"TimeGenerated").toString();
//            String eventUser = Dispatch.call(item,"User").toString();
//            resultString += "TimeGenerated: " + timeGenerated + " CategoryString: " + categoryString + " User: " + eventUser + "\r";
//        }//ending while (enumVariant.hasMoreElements())
/*
        for (Iterator<Variant> it = enumVariant.asIterator(); it.hasNext(); ) {
            Variant temp = it.next();
            Dispatch item = temp.toDispatch();
            System.out.println("computer name : {0}"+
                    Dispatch.call(item,"csname").toString());
            System.out.println("windows directory : {1}"+
                    Dispatch.call(item,"WindowsDirectory").toString());
            System.out.println("Operating System  : {2}"+
                    Dispatch.call(item,"Caption").toString());
            System.out.println("Version           : {3}"+
                    Dispatch.call(item,"Version").toString());
            System.out.println("Manufacturer      : {4}"
                    +Dispatch.call(item,"Manufacturer").toString());
            System.out.println("TotalVisibleMemorySize      : {5}"
                    +Dispatch.call(item,"TotalVisibleMemorySize").toString());

        }
*/

