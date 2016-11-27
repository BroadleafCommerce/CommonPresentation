/*
 * #%L
 * BroadleafCommerce Framework Web
 * %%
 * Copyright (C) 2009 - 2016 Broadleaf Commerce
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

package org.broadleafcommerce.common.web.cache.service;

import org.broadleafcommerce.common.web.domain.BroadleafTemplateContext;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Default implementation of {@link TemplateCacheKeyResolverService} that returns a concatenation of a 
 * templateName and cacheKey.   If the cacheKey is set to none, null is returned resulting in no cache.
 * 
 * @author Brian Polster (bpolster)
 */
@Service("blTemplateCacheKeyResolver")
public class SimpleCacheKeyResolver implements TemplateCacheKeyResolverService {
    
    /**
     * Returns a concatenation of the templateName and cacheKey separated by an "_".    
     * If cacheKey is null, only the templateName is returned.
     * 
     * If cacheKey is "none" then null will be returned causing the template not to be cached.
     * @param the tag name that the cache processor is running in
     * @param tagAttributes the attributes used in the tag or ones added by the cache processor
     * @param documentName the name of the template
     * @param lineNumber the line that the cache processor is on
     * @param context the context that the processor is executing in
     */
    @Override
    public String resolveCacheKey(String tagName, Map<String, String> tagAttributes, String documentName, Integer lineNumber, BroadleafTemplateContext context) {
        String cacheKey = getStringValue(TemplateCacheKeyResolverService.CACHE_KEY_ATTRIBUTE, tagAttributes, true, context);
        if (TemplateCacheKeyResolverService.NONE_CACHE_VALUE.equals(cacheKey)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cacheKey);
        String attributeDocName = getStringValue("templateName", tagAttributes, true, context);
        sb.append("_" + attributeDocName == null ? documentName : attributeDocName);
        sb.append("_" + lineNumber == null ? 0 : lineNumber);
        return sb.toString();
    }

    protected String getStringValue(String attrName, Map<String, String> tagAttributes, boolean removeAttribute, BroadleafTemplateContext context) {
        if (tagAttributes.containsKey(attrName)) {
            String cacheKeyParam = tagAttributes.get(attrName);
            if (removeAttribute) {
                tagAttributes.remove(attrName);
            }
            return context.parseExpression(cacheKeyParam).toString();
        }
        return "";
    }

}
