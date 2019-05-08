//全局静态变量
var applicationContent={}
applicationContent.content=$("meta[name=content]")
applicationContent.baseUrl=applicationContent.content.attr("baseUrl");
applicationContent.basePath=applicationContent.content.attr("basePath");
applicationContent.backUrl=applicationContent.content.attr("backUrl");