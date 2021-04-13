<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
	 	<title>게시판</title>
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				var formObj = $("form[name='readForm']");
				
				// 수정 
				$(".update_btn").on("click", function(){
					formObj.attr("action", "/board/updateView");
					formObj.attr("method", "get");
					formObj.submit();				
				})
				
				// 삭제
				$(".delete_btn").on("click", function(){
					var deleteYN = confirm("삭제하시겠습니까?");
					
					if(deleteYN == true){
						formObj.attr("action", "/board/delete");
						formObj.attr("method", "post");
						formObj.submit();
					}
				})
				
				// 취소
				$(".list_btn").on("click", function(){
					
					location.href = "/board/list";
				})
			})
		</script>
	</head>
	<body>
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<div>
				<%@include file="nav.jsp" %>
			</div>
			<hr />
			
			<section id="container">
				<form name="readForm" role="form" method="post">
					<input type="hidden" id="board_num" name="board_num" value="${read.board_num}" />
				</form>
				<table>
					<tbody>
						<tr>
							<td>
								<label for="board_title">제목</label><input type="text" id="board_title" name="board_title" value="${read.board_title}" readonly="readonly" />
							</td>
						</tr>	
						<tr>
							<td>
								<label for="board_content">내용</label><textarea id="board_content" name="board_content" readonly="readonly"><c:out value="${read.board_content}" /></textarea>
							</td>
						</tr>
						<tr>
							<td>
								<label for="board_date">작성날짜</label>
								<fmt:formatDate value="${read.board_date}" pattern="yyyy-MM-dd" />					
							</td>
						</tr>		
					</tbody>			
				</table>
				<div>
					<button type="submit" class="update_btn">수정</button>
					<button type="submit" class="delete_btn">삭제</button>
					<button type="submit" class="list_btn">목록</button>	
				</div>
			</section>
			<hr />
		</div>
	</body>
</html>