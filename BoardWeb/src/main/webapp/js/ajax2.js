/**
 * ajax2.js
 * serviceImpl + mapper.java 와 유사 
 */
console.log(svc.add(3,2));
  svc.replyList(131, 
		function(result){
			console.log(result);	
				result.forEach(function(item){
				console.log(item);
				let tr = makeRow(item);
				document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
				})
		},
		function(err){
			console.error(err);
		}
);
// 등록이벤트
document.querySelector('#addReply').addEventListener('click',addReplyFunc);

function addReplyFunc(){
	const boardNo = document.querySelector('#boardNo').value;
		const reply = document.querySelector('#reply').value;
		console.log(boardNo + ", "+ reply);
		if(!boardNo || !reply || !logId){
			alert('필수 요소 누락');
			return;
		}
	svc.addReply({boardNo, reply, replyer:logId},
		function(result){
			if(result.retCode=='Success'){
				alert('댓글달기 성공');
				let tr = makeRow(result.retVal);
				let target = document.querySelector('table:nth-of-type(2) tbody tr');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr , target);
			}else{
				alert('댓글달기 실패');
			}
		},
		function(err){
			console.log(err);
		});
}



function deleteReplyFunc(e){
	let replyNo = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(replyNo,
	function(result){
		if(result.retCode=='Success'){
			alert('delete complete');
			e.target.parentElement.parentElement.remove();
		}else{
			alert('delete failed');
		}
	},
	function(err){
		console.error(err);
	})
}
