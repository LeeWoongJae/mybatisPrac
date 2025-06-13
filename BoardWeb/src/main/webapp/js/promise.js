/**
 * promise.js
 * 
 * 비동기 순서를 그안에서 순서를 정하여 처리할수 있도록 만들기위해서
 * .then ~ .then ~ 
 */
// reply list output
fetch('replyList.do?boardNo=131')
// if else if else or try catch
	.then(function(data){
		// 서치가 성공했을경우에 처리되는 첫번째 함수
		//console.log(data);
		return data.json(); // json -> object
	})
	.then(function(result){
		console.log(result);
		result.forEach(function(item){
		console.log(item);
		let tr = makeRow(item);
		document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		})
	})
	.catch(function(err){
		console.log(err);
	})
	
// delete reply func
function deleteReplyFunc(e){
		
		if(!confirm("삭제하시겠습니까?")){
			return;
		}
		let replyNo = e.target.parentElement.parentElement.dataset.rno;
		fetch('removeReply.do?replyNo='+replyNo)
		.then(res=>res.json())
		.then(data=>{
			if(data.retCode=='Success'){
				alert('delete complete');
				e.target.parentElement.parentElement.remove();
			}else{
				alert('delete failed');
			}
		})
		.catch(err=>console.error(err));
		
}// end of deleteReplyFunc	

document.querySelector('#addReply').addEventListener('click' , addReplyFunc);
function addReplyFunc(){
	const boardNo = document.querySelector('#boardNo').value;
	const reply = document.querySelector('#reply').value;
	
	fetch('addReply.do',{
		method  : 'post',
		headers : {'Content-type':'application/x-www.form-urlencoded'},
		body : 'boardNo='+boardNo+'&reply='+reply+'&replyer='+logId
	})
	.then(json => json.json())
	.then((result)=>{
		if(result.retCode=='Success'){
				alert('댓글달기 성공');
				let tr = makeRow(result.retVal);
				let target = document.querySelector('table:nth-of-type(2) tbody tr');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr , target);
			}else{
				alert('댓글달기 실패');
			}	
	})
	.catch(err => console.log(err));
	}
	
	
function makeRow(item){
		let tr = document.createElement('tr'); 
			tr.setAttribute('data-rno',item.replyNo); // <tr data-replyNo="?">~~</tr>	
			for(let prop of ['replyNo','reply','replyer']){
				
			let td = document.createElement('td'); 
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