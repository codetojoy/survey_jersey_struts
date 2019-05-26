<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<s:head />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>

<h3><s:property value="testField"/></h3>

<s:iterator value="surveys" var="survey">
    <div>
    <p>S id: <s:property value="#survey.id"/></p>
    <p>S user id: <s:property value="#survey.userId"/></p>
    </div>
    <hr/>

    <s:iterator value="#survey.questions" var="question">
        <div>
        <p>
            Q name: <s:property value="#question.logicalName"/> ,
            id: <s:property value="#question.id"/> ,
            desc: <s:property value="#question.desc"/>
        </p>
        </div>

        <s:iterator value="#question.answers" var="answer">
            <div>
            <p>
                A id: <s:property value="#answer.id"/> ,
                desc: <s:property value="#answer.desc"/> ,
                comment: <s:property value="#answer.comment"/> ,
                selected: <s:property value="#answer.selected"/>
            </p>
            </div>
        </s:iterator>

    </s:iterator>

    <br/>
    <hr/>
</s:iterator>

</body>
</html>
