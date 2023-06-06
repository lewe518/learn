package com.liuyi.learn.spring.proxy.bean.spring;

import com.liuyi.learn.spring.proxy.bean.http.anno.HttpComponent;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * RepositoryScannerRegistrar
 *
 * @author xc_liuyi
 * Create at: 2023/6/6
 */
@Component
public class RepositoryScannerRegistrar extends ClassPathBeanDefinitionScanner
        implements ImportBeanDefinitionRegistrar {

    public RepositoryScannerRegistrar(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        doScan("com.liuyi.learn.spring.proxy.bean");
        addIncludeFilter((a, b) -> a.getAnnotationMetadata().hasAnnotation(HttpComponent.class.getName()));
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
}
