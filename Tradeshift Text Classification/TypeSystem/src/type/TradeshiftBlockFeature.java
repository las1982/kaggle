

/* First created by JCasGen Wed Jul 05 10:42:41 MSK 2017 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Jul 05 10:42:41 MSK 2017
 * XML source: D:/Projects/Kaggle/Tradeshift Text Classification/TypeSystem/type.xml/TradeshiftBlockFeature.type.xml
 * @generated */
public class TradeshiftBlockFeature extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TradeshiftBlockFeature.class);
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
  protected TradeshiftBlockFeature() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TradeshiftBlockFeature(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TradeshiftBlockFeature(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TradeshiftBlockFeature(JCas jcas, int begin, int end) {
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
  public String getValue() {
    if (TradeshiftBlockFeature_Type.featOkTst && ((TradeshiftBlockFeature_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "type.TradeshiftBlockFeature");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TradeshiftBlockFeature_Type)jcasType).casFeatCode_value);}
    
  /** setter for value - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setValue(String v) {
    if (TradeshiftBlockFeature_Type.featOkTst && ((TradeshiftBlockFeature_Type)jcasType).casFeat_value == null)
      jcasType.jcas.throwFeatMissing("value", "type.TradeshiftBlockFeature");
    jcasType.ll_cas.ll_setStringValue(addr, ((TradeshiftBlockFeature_Type)jcasType).casFeatCode_value, v);}    
  }

    