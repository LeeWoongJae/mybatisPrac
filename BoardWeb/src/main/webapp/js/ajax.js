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
xhtp.send();// 페이지 requestion

xhtp.onload = function(){
	console.log(xhtp.responseText);
	let data = JSON.parse(xhtp.responseText);
	data.forEach(function(item){
		console.log(item);
		let tr = document.createElement('tr'); // <tr></tr>
		
		for(let prop of ['replyNo','reply','replyer']){
			
		let td = document.createElement('td');// <td></td>
		td.innerHTML = item[prop];
		
				
		tr.appendChild(td); // <tr><td></td></tr>
		}
		//button
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerHTML="삭제";
		btn.className="btn btn-danger";
		td.appendChild(btn);
		tr.appendChild(td);
		document.querySelector('tbody').appendChild(tr);
	});
	//document.querySelector('#show').innerHTML = xhtp.responseText;
};

xhtp.onload = memberList();
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