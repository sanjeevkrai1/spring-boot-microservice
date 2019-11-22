#############Internationalization#################


-LocaleResolver
	-Default Locale - Locale.US
-ResourceBundleMessageSource



###########Uses#############
-Autowire MessageSource
-@RequestHeader(value="Accept-language" , required=false) Locale locale
-messageSource.getMessage("helloworld.message" ,null, locale)