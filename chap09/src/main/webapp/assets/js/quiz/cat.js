const chk = document.getElementById('closeAd');

chk.addEventListener('change', function() {
	if (this.checked) {
		window.close();
		
	}
});