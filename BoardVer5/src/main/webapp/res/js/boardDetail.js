function delCmt(icmt, iboard) {
/*	var uri = '/board/cmt?icmt=${icmt}&iboard=${iboard}';
	var enc = encodeURI(uri);
	console.log('iboard : ${iboard} icmt : ${icmt}');*/
	if(confirm('삭제하시겠습니까?')){
	location.href='/board/cmt?icmt='+icmt+'&iboard='+iboard;
		
	} 
}
var insFrmElem = document.querySelector('#insFrm');
var updFrmElem = document.querySelector('#updFrm');

function updCmt(icmt, cmt) {
		console.log(' iboard : %d', icmt);
		console.log(' iboard : %d', iboard);
		console.log(' iboard : %s', cmt);
		updFrm.icmt.value = icmt;
		updFrm.cmt.value = cmt;
		
		
		insFrm.className = 'hidden';
		updFrm.className =	'';
}

function showInsFrm() {
	insFrm.className = '';
	updFrm.className = 'hidden';
}