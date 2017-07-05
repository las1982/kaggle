package type;

/* First created by JCasGen Wed Jul 05 10:22:05 MSK 2017 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Jul 05 10:22:05 MSK 2017
 * XML source: D:/Projects/Kaggle/Tradeshift Text Classification/TypeSystem/type.xml/type.TradeshiftBlock.type.xml
 * @generated */
public class TradeshiftBlock extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(TradeshiftBlock.class);
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
  protected TradeshiftBlock() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public TradeshiftBlock(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public TradeshiftBlock(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public TradeshiftBlock(JCas jcas, int begin, int end) {
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
  //* Feature: category

  /** getter for category - gets The category label for a type.TradeshiftBlock
   * @generated
   * @return value of the feature 
   */
  public String getCategory() {
    if (TradeshiftBlock_Type.featOkTst && ((TradeshiftBlock_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "type.TradeshiftBlock");
    return jcasType.ll_cas.ll_getStringValue(addr, ((TradeshiftBlock_Type)jcasType).casFeatCode_category);}
    
  /** setter for category - sets The category label for a type.TradeshiftBlock
   * @generated
   * @param v value to set into the feature 
   */
  public void setCategory(String v) {
    if (TradeshiftBlock_Type.featOkTst && ((TradeshiftBlock_Type)jcasType).casFeat_category == null)
      jcasType.jcas.throwFeatMissing("category", "type.TradeshiftBlock");
    jcasType.ll_cas.ll_setStringValue(addr, ((TradeshiftBlock_Type)jcasType).casFeatCode_category, v);}    
  }

    