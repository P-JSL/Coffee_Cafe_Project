
function RealTime() {
	var date = new Date();

	// 시간
	var h = date.getHours();
	var m = date.getMinutes();
	var s = date.getSeconds();
	var AMPM = "오전";

	if (h == 0) {
		h = 12;
	}
	if (h > 11) {
		h = h - 12;
		AMPM = "오후";
	}
	
	
	h = (h<10) ? "0" + h : h;
	m = (m<10) ? "0" + m : m;
	s = (s<10) ? "0" + s : s;
	

	var time = AMPM + " " + h + "시 " + m + "분 " + s +"초 ";
	document.getElementById("RealTime").innerText = time;
	document.getElementById("RealTime").innerContent = time;
	
}

setInterval(function(){RealTime()
	
}, 1000);