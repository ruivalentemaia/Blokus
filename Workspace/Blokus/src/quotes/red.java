//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2012-12-02 by the VDM++ to JAVA Code Generator
// (v8.1.1b - Thu 30-Oct-2008 14:59:38)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
package quotes;

// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO
// ***** VDMTOOLS END Name=imports



public class red {

// ***** VDMTOOLS START Name=hc KEEP=NO
  static private int hc = 0;
// ***** VDMTOOLS END Name=hc


// ***** VDMTOOLS START Name=red KEEP=NO
  public red () {
    if (hc == 0) 
      hc = super.hashCode();
  }
// ***** VDMTOOLS END Name=red


// ***** VDMTOOLS START Name=hashCode KEEP=NO
  public int hashCode () {
    return hc;
  }
// ***** VDMTOOLS END Name=hashCode


// ***** VDMTOOLS START Name=equals#1|Object KEEP=NO
  public boolean equals (Object obj) {
    return obj instanceof red;
  }
// ***** VDMTOOLS END Name=equals#1|Object


// ***** VDMTOOLS START Name=toString KEEP=NO
  public String toString () {
    return "<red>";
  }
// ***** VDMTOOLS END Name=toString

}
;
