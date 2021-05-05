Keep the following constraints in mind when adding or updating properties files
in this folder:

1) The various Chinese translations (Resource_zh*.properties) are mostly
duplicates. There are actually only two non-duplicate Chinese translations:
Simplified Chinese and Traditional Chinese. The former is dominant in China
(zh_CN) and Singapore (zh_SG), and the latter is dominant in Hong Kong (zh_HK)
and Taiwan (zh_TW). In addition, DocFetcher uses Simplified Chinese as fallback
in case of an unexpected country code, e.g., zh_US. Consequently, the following
files are duplicates:
- Resource_zh.properties, Resource_zh_CN.properties, Resource_zh_SG.properties
- Resource_zh_HK.properties, Resource_zh_TW.properties

2) With the exception of the Chinese translations, country codes should
generally be omitted from the names of the properties files in this folder,
otherwise the program may fail to find the appropriate properties file. For
instance, if Resource_ja.properties is renamed to Resource_ja_JP.properties,
then the file will not be found if the country code is anything other than "JP".
