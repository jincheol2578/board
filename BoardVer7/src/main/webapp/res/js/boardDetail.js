	var cmtFrmElem = document.querySelector('#cmtFrm');

function regCmt(){
	var cmtVal = cmtFrmElem.cmt.value;
	
	var param= {
		iboard: cmtFrmElem.dataset.iboard,
		cmt: cmtVal
	};
	
	regAjax(param);
}

function regAjax(param) {
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	};
	
	fetch('cmtInsSel', init)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
		
		switch (myJson.result){
			case 0:
				alert('등록실패');
			break;
			case 1:
				cmtFrmElem.cmt.value = '';
				alert('등록성공');
			break;
		}
	});
}

//댓글 리스트 자료요청
function getListAjax() {
	var iboard = cmtFrmElem.dataset.iboard;
	
	fetch('cmtInsSel?iboard=' +iboard)
	.then(function(res){
		return res.json();
	})
	.then(function(myJson){
		console.log(myJson);
	});
}

getListAjax(); // js파일 임포트되면 1회 호출