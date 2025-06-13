/**
 * service.js 
 */

const svc = { // service interface와 유사
	// svc 객체의 add라는 메소드
	add : function(n1 = 0 , n2 = 0){
		return n1 + n2;
	},
	// 목록 출력
	replyList(boardNo , successCallback , errorCallback){
		fetch('replyList.do?boardNo='+boardNo)
		.then(data => data.json())
		.then(successCallback)
		.catch(errorCallback)
	},
	removeReply(replyNo, successCallback, errorCallback){
		// 삭제할 ajax 호출
		fetch('removeReply.do?replyNo='+replyNo)
		.then(data => data.json())
		.then(successCallback)
		.catch(errorCallback)
	},
	addReply(param={boardNo , reply , replyer}, successCallback, errorCallback){
		fetch('addReply.do',
			{
				method : 'post',
				headers : {'Content-Type':'application/x-www-form-urlencoded'},
				body : 'boardNo='+param.boardNo+'&reply='+param.reply+'&replyer='+param.replyer
			
			})
		.then(data => data.json())
		.then(successCallback)
		.catch(errorCallback)
	}
}
const add = (n1 = 1 , n2 = 1) => {return n1 + n2}


function makeRow(item){
		let tr = document.createElement('tr'); // <tr></tr>
			tr.setAttribute('data-rno',item.replyNo); // <tr data-replyNo="?">~~</tr>	
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
			btn.addEventListener('click', deleteReplyFunc);
			td.appendChild(btn);
			tr.appendChild(td);
		return tr;
}

