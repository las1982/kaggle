

/* First created by JCasGen Wed Jul 05 12:33:00 MSK 2017 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.jcas.cas.IntegerArray;


/** 
 * Updated by JCasGen Wed Jul 05 12:33:00 MSK 2017
 * XML source: D:/Projects/Kaggle/Tradeshift Text Classification/TypeSystem/src/type/xml/TradeshiftBlockFeatureList.xml
 * @generated */
public class TradeshiftBlockFeatureList extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TradeshiftBlockFeatureList.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected TradeshiftBlockFeatureList() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TradeshiftBlockFeatureList(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TradeshiftBlockFeatureList(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TradeshiftBlockFeatureList(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: value

  /** getter for value - gets 
   * @generated
   * @return value of the feature 
   */
  public IntegerArray getValue() {
    if (TradeshiftBlockFeatureList_Type.featOkTst && ((TradeshiftBlockFeatureList_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "type.TradeshiftBlockFeatureList");
    return (IntegerArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((TradeshiftBlockFeatureList_Type)jcasType).casFeatCode_value)));}
    
  /** setter for value - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setValue(IntegerArray v) {
    if (TradeshiftBlockFeatureList_Type.featOkTst && ((TradeshiftBlockFeatureList_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "type.TradeshiftBlockFeatureList");
    jcasType.ll_cas.ll_setRefValue(addr, ((TradeshiftBlockFeatureList_Type)jcasType).casFeatCode_value, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for value - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public int getValue(int i) {
    if (TradeshiftBlockFeatureList_Type.featOkTst && ((TradeshiftBlockFeatureList_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "type.TradeshiftBlockFeatureList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TradeshiftBlockFeatureList_Type)jcasType).casFeatCode_value), i);
    return jcasType.ll_cas.ll_getIntArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TradeshiftBlockFeatureList_Type)jcasType).casFeatCode_value), i);}

  /** indexed setter for value - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setValue(int i, int v) { 
    if (TradeshiftBlockFeatureList_Type.featOkTst && ((TradeshiftBlockFeatureList_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "type.TradeshiftBlockFeatureList");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((TradeshiftBlockFeatureList_Type)jcasType).casFeatCode_value), i);
    jcasType.ll_cas.ll_setIntArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((TradeshiftBlockFeatureList_Type)jcasType).casFeatCode_value), i, v);}
  }

    