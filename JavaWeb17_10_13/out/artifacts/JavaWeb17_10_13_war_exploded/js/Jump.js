
var Timer;
var TotalSeconds;
var result ;

window.onload = function() {
    CreateTimer("timer", 3);
    result = document.getElementById("result");
};

function CreateTimer(TimerID, Time)
{
    Timer = document.getElementById(TimerID);
    TotalSeconds = Time;
    UpdateTimer();
    window.setTimeout("Tick()", 1000);
}

function Tick()
{
    TotalSeconds -= 1;
    if(TotalSeconds <= -1)
    {

        if (result.innerHTML === "注册成功, 将跳转至登录页面.")
            /*
            see more
            http://www.w3school.com.cn/js/js_window_location.asp
             */
            window.location.href = "\\jsps\\Login.jsp";
        else {
            var re = /登录失败/;
            if (re.test(result.innerHTML)) {
                window.location.href = "\\jsps\\Login.jsp";
            }else {
                window.location.href = "\\jsps\\Logup.jsp";
            }


        }
        // Show alert Plus redirect any other page
    }
    else
    {
        UpdateTimer();
        window.setTimeout("Tick()", 1000);
    }
}

function UpdateTimer() {
    Timer.innerHTML = TotalSeconds;
}