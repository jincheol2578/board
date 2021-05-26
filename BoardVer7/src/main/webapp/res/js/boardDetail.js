var cmtFrmElem = document.querySelector('#cmtFrm');
var cmtListElem = document.querySelector('#cmtList');

function regCmt() {
	var cmtVal = cmtFrmElem.cmt.value;

	var param = {
		iboard: cmtListElem.dataset.iboard,
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
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson);

			switch (myJson.result) {
				case 0:
					alert('등록실패');
					break;
				case 1:
					cmtFrmElem.cmt.value = '';

					getListAjax();
					break;
			}
		});
}

//댓글 리스트 자료요청
function getListAjax() {
	var iboard = cmtListElem.dataset.iboard;

	fetch('cmtInsSel?iboard=' + iboard)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			console.log(myJson);

			makeCmtElemList(myJson);
		});
}

function makeCmtElemList(data) {

	cmtListElem.innerHTML = '';

	var tableElem = document.createElement('table');
	var trElemTitle = document.createElement('tr');
	var thElemCtnt = document.createElement('th');
	var thElemWriter = document.createElement('th');
	var thElemRegdate = document.createElement('th');
	var thElemBigo = document.createElement('th');

	thElemCtnt.innerText = '내용';
	thElemWriter.innerText = '작성자';
	thElemRegdate.innerText = '작성일';
	thElemBigo.innerText = '비고';

	trElemTitle.append(thElemCtnt);
	trElemTitle.append(thElemWriter);
	trElemTitle.append(thElemRegdate);
	trElemTitle.append(thElemBigo);

	tableElem.append(trElemTitle);
	cmtListElem.append(tableElem);

	var loginUserPk = cmtListElem.dataset.login_user_pk;

	data.forEach(function(item) {

		var trElemCtnt = document.createElement('tr');
		var tdElem1 = document.createElement('td');
		var tdElem2 = document.createElement('td');
		var tdElem3 = document.createElement('td');
		var tdElem4 = document.createElement('td');

		tdElem1.append(item.cmt);
		tdElem2.append(item.writerNm);
		tdElem3.append(item.regdate);

		if (parseInt(loginUserPk) === item.iuser) {
			var delBtn = document.createElement('button');
			var modBtn = document.createElement('button');
			//삭제버튼 클릭시
			delBtn.addEventListener('click', function() {
				delAjax(item.icmt);
			});

			delBtn.innerText = '삭제';
			modBtn.innerText = '수정';

			tdElem4.append(delBtn);
			tdElem4.append(modBtn);
		}

		trElemCtnt.append(tdElem1);
		trElemCtnt.append(tdElem2);
		trElemCtnt.append(tdElem3);
		trElemCtnt.append(tdElem4);

		tableElem.append(trElemCtnt);
	});
}

function delAjax(icmt) {
	fetch('cmtDelUpd?icmt=' + icmt)
		.then(function(res) {
			return res.json();
		})
		.then(function(data) {
			console.log(data);

			switch (data) {
				case 0:
					alert('삭제실패');
					break;
				case 1:
					break;
			}

			getListAjax();
		})
}
getListAjax(); // js파일 임포트되면 1회 호출






