/**
 * 
 * covid.js
 */
import {makeRow , url} from './covid_module.js';

console.log("covid.js입니다");
let centerAry;
let sidoAry=[];
fetch(url)
.then(data=>data.json())
.then(res=>{
	centerAry = res.data;
	centerAry.forEach((center, idx)=>{
		// sidoAry에 중복 sido값을 제외하고 담기
		if(sidoAry.indexOf(center.sido)==-1){
			sidoAry.push(center.sido);
		}
		 if(idx<=10){
			// makeRow();
			let tr = makeRow(center);
			document.querySelector('#centerList').appendChild(tr);

		}

	});
	
	// sidoAry의 갯수만큼 <option value="sidoInfo">sido정보</option>
	sidoAry.forEach(sido=>{
		let option = document.createElement('option');
		option.value=sido;
		option.innerText=sido;
		document.getElementById('sido').appendChild(option);
		
	})
})
.catch(err=>console.log(err));


document.querySelector('button.btn-primary').addEventListener('click',function(e){
	document.querySelector('#centerList').innerHTML="";
	let kw = document.getElementById('centerName').value;
	centerAry // fetch로 인해서 배열로 정의
	.filter(center=>center.centerName.includes(kw)) // 배열반환
	.forEach(center=>{ // 그로 인해서 forEach 가능
		let tr = makeRow(center);
		document.querySelector('#centerList').appendChild(tr);
	});
	
	
});


//select 태그의 change이벤트
document.querySelector('#sido').addEventListener('change',function(e){
	document.querySelector('#centerList').innerHTML="";
	let keyword = document.getElementById('sido').value;
	console.log(keyword);
	centerAry
	.reduce((acc , center)=>{
		if(center.sido == keyword){
			let tr = makeRow(center);
			acc.appendChild(tr);
		}
		return acc;
	},document.querySelector('#centerList'))
	
	
	
	
	//.filter(center => center.sido==keyword)
	//.forEach(center=>{
	//	let tr = makeRow(center);
	//	document.querySelector('#centerList').appendChild(tr);
		
	//})
	
});

let result = [1 , 3 , 5 , 7].reduce(function(acc, elem , idx , ary){
	console.log(acc, elem);
	// acc => 초기값 (배열이 될수도 있고 태그도 될수 있다)
	if(elem>4){
		let li = document.createElement('li');
		li.innerHTML = elem;
		acc.appendChild(li);
		
	}
	return acc;
}, document.querySelector('#target'));
console.log("결과값 : "+result);

