package cn.hlx.springframework.util;

/**
 * Simple strategy interface for resolving a String value.
 * Used by {@link cn.hlx.springframework.beans.factory.config.ConfigurableBeanFactory}.
 * <p>
 * 
 * 
 * 
 * */
public interface StringValueResolver {
    
    String resolveStringValue(String strVal);
    
}
