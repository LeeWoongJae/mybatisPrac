/**
 * reply.js
 */
// 마지막 페이지에 댓글들을 다 지웠을 경우 이전 페이지글들을 새로 출력되도록 해보기 HOMEWORK
let page = 1;

//script를 통해서 넘겨받아온것 board.boardNo값을 bno로
console.log(bno);
Date.prototype.format = function(){
	let yyyy = this.getFullYear();
	let MM = this.getMonth() + 1;
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();
	
	return yyyy + "-" + ('0'+MM).slice(-2) + "-" + ('0'+dd).slice(-2) + " " + ('0'+hh).slice(-2) +
	               ":" + ('0'+mm).slice(-2) + ":" + ('0'+ss).slice(-2);
}
// 이벤트



showReplyList();
// 댓글목록 이벤트
function showReplyList(){
	
	document.querySelector('#target').innerHTML="";
	svc.replyList({ bno, page },
		result => {
			//console.log(result);
			
			let ul = document.querySelector('#target');
			// ul 밑 첫번쨰 child를 지정
			let template = document.querySelector('#target li');
			
			for (let reply of result) {
				
				template = makeTemplate(reply);
				ul.insertAdjacentHTML("beforeend", template);
			}
			// 댓글페이지
			showPageList();
		},
		err => console.log(err)
	);
	
}

// 1)댓글이벤트
document.querySelector('#addReply').addEventListener('click' , addReplyHandler);


function pagingEvent(){
// 2)댓글링크이벤트
document.querySelectorAll('.footer nav a').forEach(function(tag , idx){
	//console.log(tag);
	tag.addEventListener('click',function(e){
		page = e.target.dataset.page;
		showReplyList();
		
	});
});
}//end of pagingEvent

function addReplyHandler(event){
	let reply = document.querySelector('#reply').value;
	
	if(!logId || !reply){
		alert("확인해주세요");
		return;
	}
	// 댓글등록
	svc.addReply({bno, reply, replyer: logId},
		result =>{
			
			let ul = document.querySelector('#targat');
			if(result.retCode=="Success"){
			let rVal = result.retVal;	
			//console.log("rVal : "+rVal);
			//ul.insertAdjacentHTML("afterbegin" , makeTemplate(rVal));
			page = 1; // 초기값 지정
			showReplyList();// 목록 출력
			document.querySelector('#reply').value ="";
			
			
			}
		},
		err =>console.log(err)
	)
}

		
// 댓글 페이징
function showPageList(){
	svc.replyCount(bno,
		result=>{
			console.log(result.totalCnt);
			let totalCnt = result.totalCnt;
			let start, end;
			let prev, next;
			let realEnd = Math.ceil(totalCnt / 5); // 건수기준으로 마지막페이지 계산
			
			end = Math.ceil(page / 10) * 10;
			start = end - 9;
			end = end > realEnd ? realEnd : end;
			prev = start > 1;
			next = end < realEnd;
			document.querySelector('nav ul.pagination-sm').innerHTML="";
			let str;	
			// page list output
			let target= document.querySelector('nav ul.pagination-sm');
			
			if(prev){
				str = `<li class="page-item active">
				        <a class="page-link" href="#" data-page="${start-1}">Previous</a></li>`;
			}
			else{
				str = `<li class="page-item disabled"><span class="page-link">Previous</span></li>`;
			}	
			target.insertAdjacentHTML('beforeend',str);
			for(let p=start;p<=end;p++){
				if(p==page){
					str = `<li class="page-item active" aria-current="page">
							<span class="page-link">${p}</span></li>`;
				}else{
					str = `<li class="page-item"><a class="page-link" href="#" data-page="${p}">${p}</a></li>`;
				}
				
				target.insertAdjacentHTML('beforeend',str);
			}	
			
			if(next){
				str = `<li class="page-item active"><a class="page-link" href="#" data-page="${end+1}">NEXT</a></li>`;
			}
			else{
				str = `<li class="page-item disabled"><span class="page-link">NEXT</span></li>`;
			}
			
			target.insertAdjacentHTML('beforeend',str);
			pagingEvent();
		},
		err=>console.log(err)
	);	
}// end of showPageList



// 댓글화면출력
function makeTemplate(reply={}){
	
	let rdate = new Date(reply.replyDate).format();
	template = `
			<li data-rno="${reply.replyNo}">
				<span class="col-sm-1">${reply.replyNo}</span>
				<span class="col-sm-4">${reply.reply}</span>
				<span class="col-sm-2">${reply.replyer}</span>
				<span class="col-sm-3">${rdate}</span>
				<span class="col-sm-1"><button onClick="deleteReply(event)" class="btn btn-danger">삭제</button></span>
			</li>
			`;
			
	return template;
}



async function deleteReply(event){
	let rno = event.target.parentElement.parentElement.dataset.rno;
	let data = await fetch('replyInfo.do?replyNo='+rno);
	let result = await data.json();
	if(result.replyer != logId){
		alert('lack the permission');
		return;
	}
	svc.removeReply(rno
		,result => {
			//if(e.target.replyer!=logId){console.log(e.target.replyer); return;}
			result.totalCnt--;
				if(result.retCode=="Success"){
					alert("처리성공");
					//event.target.parentElement.parentElement.remove();
					showReplyList();
				}
				else {
					alert("처리실패");
				}
		
		}
		,err => console.log(err)
	)
}

