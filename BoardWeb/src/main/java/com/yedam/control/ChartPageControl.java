package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class ChartPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// WEB-INF/jsp/chart/chart.jsp << 데이터내용만 가져와
		// chart/chart.tiles << 일정 영역에 데이터를 뿌려서 설정하겠다
		
		req.getRequestDispatcher("chart/chart.tiles").forward(req, resp);
	}

}
