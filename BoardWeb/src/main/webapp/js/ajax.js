/**
 * Asychronous Javascript And xml 
 */
// 비동기 vs 동기

// 동기방식 = 순차처리(하나의 작업단위가 마쳐야 다음 작업단위를 시작)
// 비동기 = 작업시간이 짧은거부터 먼저처리
/*
setTimeout(function(){
	console.log("1");
	}, 3000);

setTimeout(function(){
	console.log("2");
	}, 2000);

setTimeout(function(){
	console.log("start");
	}, 1500);
*/
console.log("start");
let xhtp = new XMLHttpRequest();
//xhtp.open('get' , 'data/sample.json'); // 요청할 페이지를 지정
xhtp.open('get' , 'replyList.do?boardNo=131');
xhtp.send(); // 페이지 requestion

xhtp.onload = function(){
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText); // javascript 객체로 parsing
	data.forEach(function(item){
		console.log(item);
	let tr = makeRow(item);
	document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};

// add reply
document.querySelector('#addReply').addEventListener('click' , addReplyFunc);

function addReplyFunc(e){
	const boardNo = document.querySelector('#boardNo').value;
	const reply = document.querySelector('#reply').value;
	
	if(!boardNo || !reply || !logId){
		alert('필수 요소 누락');
		return;
	}
	const addAjax = new XMLHttpRequest();
	addAjax.open('get' , 'addReply.do?boardNo='+boardNo+"&reply="+reply+"&replyer="+logId);
	addAjax.send();
	addAjax.onload = function(ev){
		let result = JSON.parse(addAjax.responseText);
		if(result.retCode == 'Success'){
			let tr = makeRow(result.retVal);
			let target = document.querySelector('table:nth-of-type(2) tbody tr');
			document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr , target);
		}else{
			alert('등록 실패');
		}
	}
	
}// end of addReplyFunc



// delete reply function
function deleteReplyFunc(e){
	console.log(e);
	if(!confirm("삭제하시겠습니까?")){
		return;
	}
	// data- ~ 생성시 set 컬렉션으로 값들이 생성 저장된다
	let replyNo = e.target.parentElement.parentElement.dataset.rno;
	console.log(replyNo);
	const delAjax = new XMLHttpRequest();
	delAjax.open('get', 'removeReply.do?replyNo='+replyNo); // uri상에 적기만 한 느낌
	delAjax.send();// push the enter key 
	delAjax.onload = (ev) => {
		let result = JSON.parse(delAjax.responseText);
		if(result.retCode == 'Success'){
			e.target.parentElement.parentElement.remove(); // 화면에서 숨기기 hide
		}else{
			alert('처리 실패');
		}
	}
}// end of deleteReplyFunc

function makeRow(item){
	let tr = document.createElement('tr'); // <tr></tr>
		tr.setAttribute('data-rno',item.replyNo); // <tr data-replyNo="?">~~</tr>	
		for(let prop of ['replyNo','reply','replyer']){
			
		let td = document.createElement('td'); // <td></td>
		td.innerHTML = item[prop];
			
					
		tr.appendChild(td); // <tr><td></td></tr>
		}
		//button
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerHTML="삭제";
		btn.className="btn btn-danger";
		btn.addEventListener('click', deleteReplyFunc);
		td.appendChild(btn);
		tr.appendChild(td);
	return tr;
}




//xhtp.onload = memberList();
function memberList(){
	console.log("1");
	console.log(xhtp.responseText);
	// json parsing
	let data = JSON.parse(xhtp.responseText);
	console.log(data);
	let str = "<ul>";
	data.forEach(function(item , idx , arr){
		
		str += "<li>"+item.id+",&nbsp;&nbsp;"+item.first_name+"</li>";
	});
	str += "</ul>";
	document.querySelector('#show').innerHTML = str;
}
console.log("end");
	
//fetch('data/sample.json')




/*.then(resolve=>resolve.json())
.then(data =>{
	console.log(data);
	data.forEach();
})
.catch(err=>{
	console.log(err);
})
*/