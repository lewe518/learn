package com.liuyi.learn.spring.proxy.bean.spring;

import com.liuyi.learn.spring.proxy.bean.http.anno.HttpComponent;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * HttpComponentScanner
 *
 * @author xc_liuyi
 * Create at: 2023/6/7
 */
public class HttpComponentScanner extends ClassPathBeanDefinitionScanner {
    public HttpComponentScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public void registerFilters(boolean includeAll) {
        if (includeAll) {
            addIncludeFilter((a, b) -> true);
        } else {
            addIncludeFilter((a, b) -> a.getAnnotationMetadata().hasAnnotation(HttpComponent.class.getName()));
        }
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        for (BeanDefinitionHolder holder : beanDefinitionHolders) {
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) holder.getBeanDefinition();
            String beanClassName = beanDefinition.getBeanClassName();
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanClassName);
            beanDefinition.setBeanClass(HttpFactoryBean.class);
            beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
        }
        return beanDefinitionHolders;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
    }
}
