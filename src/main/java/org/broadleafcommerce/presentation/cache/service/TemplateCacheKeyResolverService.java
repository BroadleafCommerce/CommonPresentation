/*-
 * #%L
 * BroadleafCommerce Common Presentation
 * %%
 * Copyright (C) 2009 - 2024 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.presentation.cache.service;

import org.broadleafcommerce.presentation.model.BroadleafTemplateContext;

import java.util.Map;

/**
 * Used to build a cacheKey for caching templates.
 * @author Brian Polster (bpolster)
 */
public interface TemplateCacheKeyResolverService {
    
    public static final String CACHE_KEY_ATTRIBUTE = "cacheKey";
    public static final String NONE_CACHE_VALUE = "none";

    /**
     * Takes in the Thymeleaf arguments, element, and templateName.    Returns the cacheKey by which
     * this template can be cached.      
     * 
     * @see SimpleCacheKeyResolver
     * 
     * @param arguments
     * @param element
     * @return
     */
    public String resolveCacheKey(String tagName, Map<String, String> tagAttributes, String documentName, Integer lineNumber, BroadleafTemplateContext context);
}
