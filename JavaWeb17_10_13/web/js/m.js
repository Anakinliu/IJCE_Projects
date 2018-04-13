var usernameObj;
var passwordObj;
var confirmPasswordObj;
var verifyCode;
window.onload = function() {	// 页面加载之后, 获取页面中的对象
	
	usernameObj = document.getElementById("un");
	passwordObj = document.getElementById("pw");
    confirmPasswordObj = document.getElementById("cf");
    verifyCode=document.getElementById("code");
	errorMsg = document.getElementById("msg");
};





function checkUsername() {		// 验证用户名
	var regex = /^[0-9a-zA-Z_]{0,9}$/;	// 字母数字下划线1到10位, 不能是数字开头
	var value = usernameObj.value;// value获取usernameObj中的文本
	var msg = "";						// 最后的提示消息, 默认为空
	if (!value)							// 如果用户名没填, 填了就是一个字符串可以当作true, 没填的话不论null或者""都是false
		msg = "用户名必须填写";			// 改变提示消息
	else if (!regex.test(value))		// 如果用户名不能匹配正则表达式规则
		msg = "用户名不合法";			// 改变提示消息
			// 将提示消息放入SPAN
	errorMsg.innerHTML = msg;
	usernameObj.focus();
	//usernameObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";	// 根据消息结果改变tr的颜色
	return msg ;					// 如果提示消息为空则代表没出错, 返回true
}

function checkPassword() {		// 验证密码
	var regex = /^.{6,16}$/;			// 任意字符, 6到16位
	var value = passwordObj.value;
	var msg = "";
	if (!value)
		msg = "密码必须填写";
	else if (!regex.test(value))
		msg = "密码不合法";
	errorMsg.innerHTML = msg;
	passwordObj.focus();
	//passwordObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
	return msg ;
}
//=======
function submitUP() {
    // 注册与登录共用, 而登录不需要确认密码
    if (confirmPasswordObj == null) {
        return !checkUsername() && !checkPassword()
    }
	return !checkUsername() && !checkPassword() && !confirmPassword();
}
//======
function clearUP() {		// 清空un框和pw框
	passwordObj.value = "";
	usernameObj.value = "";
}

function confirmPassword() {
    var password = passwordObj.value;
    var confirmPassword = confirmPasswordObj.value;
    var msg = "";
    if (!(password === confirmPassword)) {
        msg = "密码不一致";
    }
    errorMsg.innerHTML = msg;
    passwordObj.focus();
    //passwordObj.parentNode.parentNode.style.color = msg == "" ? "black" : "red";
    return msg ;
}

// 刷新验证码
function reloadCode(){
    verifyCode.setAttribute("src","/authImg" + "?id=" + Math.random());
//这里必须加入随机数不然地址相同我发重新加载
}