$(document).ready(function() {
	bindEvents();
	uyeKayit();
});

function bindEvents() {
	$("#girisButon").click(function() {
		$.cookie("kullaniciEmail", $("#email").val());
		var requestData = {
				email: $('#email').val(),
				sifre: $('#sifre').val()
			};
		
		$.ajax({
            type: 'POST', dataType: 'json', contentType: 'application/json; charset=utf-8',
            url: 'http://localhost:8080/ZindeKalWebServis/ws/uyeGiris/uyeGirisKontrol',
            data: JSON.stringify(requestData),
            success: function (ali) {
        		onSuccess(ali);
            }
        });
	});
};



function onSuccess(response) {
	alert("basarili: " + response.success + ", mesaj: " + response.mesaj);
};

function uyeKayit(){
	$("#kayitButon").click(function() {
		var requestData = {
				email: $('#email').val(),
				sifre: $('#sifre').val(),
				cinsiyet: $('#cinsiyet').val(),
				dogumTarihi: $('#dogumTarihi').val(),
				isim: $('#isim').val(),
				soyisim: $('#soyisim').val(),
				telefon: $('#telefon').val()
			};
		
		$.ajax({
            type: 'POST', dataType: 'json', contentType: 'application/json; charset=utf-8',
            url: 'http://localhost:8080/ZindeKalWebServis/ws/uyeGiris/uyeKayit',
            data: JSON.stringify(requestData),
            success: function (ali) {
        		onSuccess(ali);
            }
        });
		
	});
	
}