
const replyContent = document.querySelector('#replyContent');
const replyForm = document.querySelector('#replyForm');
const replyWriter = document.querySelector('#replyWriter');
const replyPassword = document.querySelector('#replyPassword');

replyContent.addEventListener('keydown', (e) => {
	console.log(e);
	
	if (e.keyCode === 13) {
		// shift �ȴ����� Enter�ϸ� submit()
		if (!e.shiftKey) {
			
			e.preventDefault();
			
			// console.dir(replyPassword.value);
			// console.dir(typeof replyPassword.value);
			
			if (replyWriter.value.trim() === '') {
				alert('�۾��̰� ����ֽ��ϴ�.');
				return;
			} else if (replyPassword.value.trim() === '' || replyPassword.value.length < 5) {
				alert('��й�ȣ�� 4���� �̻��̾�� �մϴ�.');
				return;
			}
			replyForm.submit();
		} else {
			//shift + Enter�ϸ� ��ۿ��� ���� �ٲ��ֱ�
			replyContent.innterText += '\n';
		}
		
	}
	
});