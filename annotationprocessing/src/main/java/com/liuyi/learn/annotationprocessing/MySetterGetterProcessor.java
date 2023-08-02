package com.liuyi.learn.annotationprocessing;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.liuyi.learn.annotationprocessing.MySetterGetter")
@AutoService(Processor.class)
public class MySetterGetterProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(MySetterGetter.class);
        for (Element element : elements) {
            generateGetterMethod();
            generateSetterMethod();
        }
        return false;
    }

    private void generateSetterMethod() {
    }

    private void generateGetterMethod() {
    }
}
