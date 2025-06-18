/**
 * covid_module.js
 */
const defaultNum = 10;
let url = "http://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=254&serviceKey=vExVsx1FJkY9Uma%2BjJadUHgr%2BPmrFWpSYvG64oal%2FQDNkwHqVRw%2B68%2Bl3hmjmyB7SNjoN%2BtUI9j%2FljKQObjoFg%3D%3D";
function makeRow(center){
	let tr = document.createElement('tr');
	for (const prop of ['id', 'centerName','phoneNumber']) {
		let td = document.createElement('td');
		td.innerHTML = center[prop];
		tr.appendChild(td);
	}
	return tr;

}
export {defaultNum, url , makeRow}