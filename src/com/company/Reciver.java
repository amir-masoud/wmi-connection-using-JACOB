package com.company;


//imports
import com.jacob.activeX.*;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComFailException;
import com.jacob.com.Dispatch;
import com.jacob.com.EnumVariant;
import com.jacob.com.Variant;
import java.util.Iterator;


public class Reciver {

    //methods defined to recive resulst from wmi
    public void resultOf_Win32_OperatingSystem(EnumVariant myEnumVariant){
        for (Iterator<Variant> it = myEnumVariant.asIterator(); it.hasNext(); ) {
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

        }//end of for
    }//end of public void resultOf_Win32_OperatingSystem()

    public void resultOf_CIM_Action(EnumVariant myEnumVariant){
        for (Iterator<Variant> it = myEnumVariant.asIterator(); it.hasNext(); ) {
            Variant temp = it.next();
            Dispatch item = temp.toDispatch();
            System.out.println("Version : "+
                    Dispatch.call(item,"Version").toString());
            //System.out.println("TargetOPeratingSystem : "+
              //      Dispatch.call(item,"TargetOPeratingSystem").toString());
        }//end of for
    }//end of public void resultOf_CIM_Action()


    public void resultOf_CIM_Chip(EnumVariant myEnumVariant){
        for (Iterator<Variant> it = myEnumVariant.asIterator(); it.hasNext(); ) {
            Variant temp = it.next();
            Dispatch item = temp.toDispatch();
            System.out.println("TotalWidth : "+
                    Dispatch.call(item,"TotalWidth").toString());
            System.out.println("MemoryType : "+
                    Dispatch.call(item,"MemoryType").toString());
            System.out.println("Manufacturer : "+
                    Dispatch.call(item,"Manufacturer").toString());
        }//end of for
    }//end of resultOf_CIM_Chip


    public void resultOf_MicrosoftDNS_AType(EnumVariant myEnumVariant,ActiveXComponent wmiconect){
        for (Iterator<Variant> it = myEnumVariant.asIterator(); it.hasNext(); ) {
            Variant temp = it.next();
            Dispatch item = temp.toDispatch();
            System.out.println(item.getProgramId());
            System.out.println("RecordData : "+
                    Dispatch.call(item,"RecordData").toString());
            System.out.println("OwnerName : "+
                    Dispatch.call(item,"OwnerName").toString());
            System.out.println("IPAddress : "+
                    Dispatch.call(item,"IPAddress").toString());
            System.out.println("TTL : "+
                    Dispatch.call(item,"TTL").toString());
            //Dispatch.call(item,"RecordData","salam");
            //Dispatch.call(item,"IPAddress","192.111.111.0");
            //Dispatch.call(item,"CreateInstanceFromPropertyData",new Object[]{new Variant("\"RecordData\",\"salam\"")});
            System.out.println("-------------------------");

        }//end of for

    }//end of public void resultOf_MicrosoftDNS_AType(EnumVariant myEnumVariant)





}//end of class Reciver
