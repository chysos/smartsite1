// ajax get
function getAjaxData(url, paramData, callback) {
    if (!url.match("http://")) {
        url = apiUrl + url;
    }

    $.ajax({
        timeout : (1000 * 60),
        type : "GET",
        url : url,
        dataType : "json",
        // contentType : 'application/json; charset=UTF-8',
        crossDomain : true,
        global : false,
        cache : false,
        async : false,
        data : paramData,
        beforeSend : function() {
            // console.log('before send');
        },
        success : function(jsonData) {
            // console.log('success');
            result = jsonData;
            callback(result);
        },
        error : function(xhr, ajaxOptions, thrownError) {
            result = {
                result : "9999"
            };
            callback(result);
        }
    });
}
// ajax post
function postAjaxData(url, paramData, callback) {
    if (!url.match("http://")) {
        url = apiUrl + url;
    }

    $.ajax({
        timeout : (1000 * 60),
        type : "POST",
        url : url,
        dataType : "json",
        // contentType : 'application/json; charset=UTF-8',
        crossDomain : true,
        global : false,
        cache : false,
        async : false,
        data : paramData,
        beforeSend : function() {
            // console.log('before send');
        },
        success : function(jsonData) {
            // console.log('success');
            result = jsonData;
            callback(result);
        },
        error : function(xhr, ajaxOptions, thrownError) {
            result = {
                result : "9999"
            };
            callback(result);
        }
    });
}

// 获取URL中某一个key所对应的value值
function cts_getParameter(param) {
	var returnValue;
	var url = location.href;
	var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&');
	for (var i = 0; i < parameters.length; i++) {
		var varName = parameters[i].split('=')[0];
		if (varName.toUpperCase() == param.toUpperCase()) {
			returnValue = parameters[i].split('=')[1];
			return decodeURIComponent(returnValue);
		}
	}
}

// 去除数组重复元素
function uniqueArray(data) {
	data = data || [];
	var a = {};
	for (var i = 0; i < data.length; i++) {
		var v = data[i];
		if (typeof (a[v]) == 'undefined') {
			a[v] = 1;
		}
	}
	;
	data.length = 0;
	for ( var i in a) {
		data[data.length] = i;
	}
	return data;
}

// 邮箱正则
function isEmail(str) {
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	return reg.test(str);
}

// 比较2个日期 返回true 第一个大,false 第二个大
function tabcom(date1, date2) {
	var str;
	var oDate1 = new Date(date1);
	var oDate2 = new Date(date2);
	if (oDate1.getTime() >= oDate2.getTime()) {
		str = true;
	} else {
		str = false;
	}
	return str;
}
