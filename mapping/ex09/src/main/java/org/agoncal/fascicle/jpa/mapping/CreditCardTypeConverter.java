package org.agoncal.fascicle.jpa.mapping;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import static org.agoncal.fascicle.jpa.mapping.CreditCardType.*;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
@Converter(autoApply = true)
public class CreditCardTypeConverter implements AttributeConverter<CreditCardType, String> {

  @Override
  public String convertToDatabaseColumn(CreditCardType creditCardType) {
    switch (creditCardType) {
      case VISA:
        return "V";
      case AMERICAN_EXPRESS:
        return "A";
      case MASTER_CARD:
        return "M";
      default:
        throw new IllegalArgumentException("Unknown" + creditCardType);
    }
  }

  @Override
  public CreditCardType convertToEntityAttribute(String dbData) {
    switch (dbData) {
      case "V":
        return VISA;
      case "A":
        return AMERICAN_EXPRESS;
      case "M":
        return MASTER_CARD;
      default:
        throw new IllegalArgumentException("Unknown" + dbData);
    }
  }
}
// end::adocSnippet[]
