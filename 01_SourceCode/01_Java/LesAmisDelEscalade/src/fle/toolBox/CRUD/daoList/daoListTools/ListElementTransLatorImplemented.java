package fle.toolBox.CRUD.daoList.daoListTools;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import fle.toolBox.Internationalization.Internationalization;
import fle.toolBox.dataListDisplayerTools.annotations.ToTranslate;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFields;
import fle.toolBox.fieldsReflectivity.extractSetAndGetComponents.ClassFieldsSetAndGet;

@Service
public class ListElementTransLatorImplemented extends Internationalization implements ListElementTransLator {

	@Autowired
	MessageSource messageSource;

	Class<ToTranslate> annotation = ToTranslate.class;

	@Override
	public <O extends Object> List<O> listI18N(List<O> list) {
		List<O> listTrad = list.stream().map(o -> entityTrad(o)).collect(Collectors.toList());
		return listTrad;
	}

	private <O extends Object> O entityTrad(O entity) {
		for (Field field : toTranslate(entity)) {
			setSuffix(suffix(field));
			setElementTranslated(entity, field);
		}
		return entity;
	}

	private <O extends Object> ArrayList<Field> toTranslate(O entity) {
		return ClassFields.getFieldsListByAnnotation(entity, annotation);
	}

	private String suffix(Field field) {
		return field.getAnnotation(annotation).suffix();
	}

	private <O extends Object> void setElementTranslated(O entity, Field field) {
		ClassFieldsSetAndGet.setField(entity, field.getName(), elementTranslator(entity, field));
	}

	private <O extends Object> String key(O entity, Field field) {
		return createKey(ClassFieldsSetAndGet.getFieldValue(entity, field.getName()).toString());
	}

	private <O extends Object> String elementTranslator(O entity, Field field) {
		return messI18n(key(entity, field), messageSource);
	}

}
