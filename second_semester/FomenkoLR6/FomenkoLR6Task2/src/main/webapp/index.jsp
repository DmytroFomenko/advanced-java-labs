<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link href="styles.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>Converter</title>
</head>
<body>
<div style="color: darkorange">
    <h1>${title}

        <p class="chooseLangLabel">${chooseLangLabel}</p>

        <form action="MainPageServlet" method="post">
            <input type="submit" value="✔" class="okButton">
            <select name="language" id="language" class="chooseLangList">
                <option value="0">${choose}</option>
                <option value="en">EN</option>
                <option value="uk">UA</option>
                <option value="de">DE</option>
                <option value="fr">FR</option>
                <option value="sk">SK</option>
            </select>
        </form>
    </h1>
    <h3>
        <c:set var="now" value="${date}"/>
        <p>📅 <font color="#cd853f"><fmt:formatDate pattern="${datePattern}" value="${now}"/></font></p>
    </h3>
</div>

<div style="height: 200px"></div>

    <div style="margin-left: 20%; width: 20%" class="inline">${changing}</div>
    <div style="margin-right: 20%; float: right; text-align: right; width: 20%" class="inline">${get}</div>

<div style="text-align: center;">
    <h2>
        <span>
            <form action="ConverterServlet" method="post">

                <select name="fromCur" id="fromCur" class="currencyList">
                    <option value="UAH" ${selFromUAH}>${UAH}</option>
                    <option value="EUR" ${selFromEUR}>${EUR}</option>
                    <option value="USD" ${selFromUSD}>${USD}</option>
                </select>

                <input type="text" name="fromSum" placeholder="${from}" value="${fromSum}" pattern="([\d]+[.][\d]+)|[\d]+" required class="convertForm">

                <input type="submit" value="&#10140;" class="convertButton">

                <input type="text" name="toSum" placeholder="${to}" value="${toSum}" class="convertForm">

                <select name="toCur" id="toCur" class="currencyList">
                    <option value="UAH" ${selToUAH}>${UAH}</option>
                    <option value="EUR" ${selToEUR}>${EUR}</option>
                    <option value="USD" ${selToUSD}>${USD}</option>
                </select>

            </form>
        </span>
    </h2>

</div>
<div class="dateUnderConverter">
    <p>${exchangeOnLabel} <font color="#cd853f"><fmt:formatDate pattern="${datePattern}" value="${now}"/></font></p>
</div>

</body>
</html>