package com.company;

import com.jacob.activeX.*;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.*;

import java.util.Iterator;

public class Shutdown {
    public static void main(String[] args) {

            ActiveXComponent wmi1 = new ActiveXComponent("WbemScripting.SWbemLocator");;//winmgmts:{impersonationLevel=impersonate,(Shutdown)}!\\.
            Variant[] variantParameters = new Variant[4];
            variantParameters[0] = new Variant("192.168.0.1");
            variantParameters[1] = new Variant("root\\MicrosoftDNS"); //cimv2
            variantParameters[2] = new Variant("masoud");
            variantParameters[3] = new Variant("1234");
            Variant conRet1 = wmi1.invoke("ConnectServer", variantParameters);
            ActiveXComponent wmiconect1 = new ActiveXComponent(conRet1.toDispatch());
            EnumVariant enumVariant1 = new EnumVariant(conRet1.toDispatch());
            String query1 = "select * from MicrosoftDNS_AType";
            Variant vCollection = wmiconect1.invoke("ExecQuery", new Variant(query1));
            for (Iterator<Variant> it = enumVariant1.asIterator(); it.hasNext(); ) {
                Variant temp = it.next();
                Dispatch item = temp.toDispatch();
                System.out.println("RecordData : "+
                    Dispatch.call(item,"RecordData").toString());
        }//end of for
            System.out.println("ending shutdown");



    }
}
