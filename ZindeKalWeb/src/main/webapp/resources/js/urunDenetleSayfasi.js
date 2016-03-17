function dolulukTesti() {
	if (document.getElementById("Username").value.length <= 0) {
		alert("message");
		return false;
	}
	return true;
}

function gorunurYap() {
	document.getElementById("urunlist").style.display="table";
}