<%-- 
    Document   : aboutUs
    Created on : Sep 25, 2021, 11:33:08 AM
    Author     : macth
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/aboutus" var="action"/>

<main id="main">

    <!-- ======= Breadcrumbs Section ======= -->
     <section style="margin-top: -50px; margin-bottom: -30px;" class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2  style=" font-weight: bold;" >Về Chúng Tôi</h2>
          <ol>
            <li><a href="http://localhost:8080/WebPhongKham/">Trang chủ</a></li>
              <li>
              <c:if test="${pageContext.request.userPrincipal.name == null}">
     
                <a href="<c:url value="/login"/>"><i class="fa fa-user"></i>Đăng nhập</a>
             </c:if>
    
             <c:if test="${pageContext.request.userPrincipal.name != null}">
            
                <a href="<c:url value="/login"/>"><i class="fa fa-user"></i> ${pageContext.request.userPrincipal.name}</a>
             </c:if>
          </li>
          </ol>
        </div>

      </div>
    </section>

    <section class="inner-page">
      
        <div class="main">
            
            <!-- Nơi để source -->
                <div class=" col-md-12 col-sm-12 col-xs-12 pd5 h1lienhe">
                    <div class="info-description-article clearfix">
                        <div style="width:950px; margin:0 auto;">
                        <p style="padding: 0px; font-size: 13px; color: rgb(79, 191, 242); line-height: 18px; margin-top: 5px; font-family: arial; text-align: justify; background-image: none !important; background-position: initial !important; background-size: initial !important; background-repeat: initial !important; background-attachment: initial !important; background-origin: initial !important; background-clip: initial !important;"></p>
                        <p style="text-align: center;"><strong><span style="font-size:22px;">LỊCH SỬ HÌNH THÀNH </span></strong></p>
                        <p style="text-align: center;"><span style="color:#FF0000;"><span style="font-size:22px;">PHÒNG KHÁM ĐA KHOA TÂM AN</span></span></p>
                        <p style="text-align: justify;"><br>
                        <img alt="" src="https://res.cloudinary.com/ikj/image/upload/v1632560039/LICH_SU_HINH_THANH_fu5chn.png" style="width: 400px; height: 884px; float: left; margin: 0px 15px 5px 0px;">-&nbsp; <strong>Năm 1995- 2016</strong>: Trên 20 năm, <span style="color:#FF0000;"><em>một chặng đường ươm mầm và phát triển</em></span>, bắt đầu hình thành từ một Phòng Khám Chuyên Khoa ở vùng ngoại ô Tp. Tại mảnh đất Nhà Bè nơi có rất nhiều thiếu thốn, khó khăn, nhất là về Y Tế. Chúng Tôi từng bước có được sự tín nhiệm của bà con địa phương.<br>
                        -&nbsp;<strong> Tháng 09/2016</strong>: Theo định hướng và để đáp ứng nhu cầu chăm sóc sức khỏe ngày một nâng cao, từ Phòng khám chuyên khoa, hiện nay đã <span style="color:#FF0000;"><em>trở thành Phòng Khám Đa Khoa.</em></span><br>
                        -&nbsp; <strong>Tháng 06/2017:</strong> <strong>Sở Y Tế đánh giá và phân loại</strong> <strong>PKĐK Tâm An vinh dự được đứng vào Nhóm I</strong> (bao gồm PKĐK Tâm An, PKĐK Hoàn Mỹ, PKĐK Đại Phước) đạt đa số các tiêu chuẩn chất lượng trong khám chữa bệnh.<br>
                        -&nbsp; <strong>Tháng 08/2017</strong>: Để giảm bớt chi phí khi ốm đau của người dân, hướng theo chính sách An Sinh Xã Hội của Nhà Nước, Chúng tôi đã phấn đấu <span style="color:#FF0000;"><em>trở thành nơi khám chữa Bệnh BHYT, đại lý bán thẻ BHYT vào tháng 12/2018</em></span>.<br>
                        -&nbsp; Hiện tại Phòng khám hoạt động 11 chuyên khoa, gồm các khoa lâm sàng và cận lâm sàng, cùng đội ngũ Bác Sĩ có trình độ CKI, CKII, THẠC SĨ, nhân viên y tế có trình độ chuyên môn nghiệp vụ cao, kỹ năng giao tiếp ứng xử tốt và thường xuyên được huấn luyện cập nhật kiến thức. Chuẩn hóa quy trình, ứng dụng công nghệ thông tin, hợp tác phát triển các chuyên khoa sâu. Hòa cùng những định hướng đúng đắn đó là tinh thần đoàn kết tập thể với sự nỗ lực, kiên trì không mệt mỏi của đội ngũ đã khẳng định thương hiệu: 
                        <span style="color:#FF0000;"><strong>Tâm An – Vạn Sự An</strong></span>. Phòng khám đã tiếp nhận và xử lý rất nhiều bệnh nặng, vận chuyển an toàn, hỗ trợ tuyến trên cứu sống được nhiều bệnh nhân, giải quyết&nbsp; được nhiều bệnh lý đa dạng và cấp tính, đặc biệt đối với lượng bệnh mãn tính - đã hỗ trợ giảm tải cho tuyến trên.<br>
                        -&nbsp; Nhằm nâng cao chất lượng cuộc sống của Cộng đồng, với định hướng chăm sóc sức khỏe toàn diện theo mô hình Bác Sĩ gia đình, chúng tôi đẩy mạnh công tác chăm sóc sức khỏe ban đầu với phương châm : “Phòng bệnh hơn chữa bệnh” hướng người dân có ý thức bảo vệ sức khỏe cho cá nhân, gia đình, đoàn thể bằng việc Khám Sức&nbsp; Khoẻ Tổng Quát định kỳ hằng năm. Và để <strong>đẩy mạnh mô hình Khám Sức&nbsp; Khoẻ Tổng Quát đúng chuẩn theo thông tư 14</strong> cho mọi đối tượng, chúng tôi đang triển khai thêm 3 chuyên khoa : Răng hàm mặt, Mắt, Da liễu. Phòng Khám Đa khoa Tâm An ngày một hoàn thiện hơn với mong muốn làm tốt nhất công tác bảo vệ sức khỏe, mang lại niềm An vui - Hạnh phúc cho cộng đồng.</p>

                        <p>&nbsp;</p>
                        </div>
                        </div>     
                        <div class="info-title-comment" style="display: none;"><i class="fa fa-comment-o"></i>Bình luận</div>
                        <div class="info-box-comment" style="display: none;">
                        <div class="container-fluid">
                         <div id="fb-root" class=" fb_reset"><div style="position: absolute; top: -10000px; width: 0px; height: 0px;"><div></div></div></div>
                         <script>(function(d, s, id) {
                          var js, fjs = d.getElementsByTagName(s)[0];
                          if (d.getElementById(id)) return;
                          js = d.createElement(s); js.id = id;
                          js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.9&appId=427739547610265";
                          fjs.parentNode.insertBefore(js, fjs);
                        }(document, 'script', 'facebook-jssdk'));
                        </script>
                        <div class="fb-comments fb_iframe_widget fb_iframe_widget_fluid_desktop" data-href="http://phongkhamtaman.com/bai-viet/ve-chung-toi.html" data-width="100%" data-numposts="5" fb-xfbml-state="rendered" fb-iframe-plugin-query="app_id=427739547610265&amp;container_width=0&amp;height=100&amp;href=http%3A%2F%2Fphongkhamtaman.com%2Fbai-viet%2Fve-chung-toi.html&amp;locale=vi_VN&amp;numposts=5&amp;sdk=joey&amp;version=v2.9&amp;width=" style="width: 100%;"><span style="vertical-align: bottom; width: 100%; height: 0px;"><iframe name="f243b0c663ee09" width="1000px" height="100px" data-testid="fb:comments Facebook Social Plugin" title="fb:comments Facebook Social Plugin" frameborder="0" allowtransparency="true" allowfullscreen="true" scrolling="no" allow="encrypted-media" src="https://www.facebook.com/v2.9/plugins/comments.php?app_id=427739547610265&amp;channel=https%3A%2F%2Fstaticxx.facebook.com%2Fx%2Fconnect%2Fxd_arbiter%2F%3Fversion%3D46%23cb%3Df23eb1dcd24f8a4%26domain%3Dphongkhamtaman.com%26is_canvas%3Dfalse%26origin%3Dhttp%253A%252F%252Fphongkhamtaman.com%252Ff34cf6a78f628cc%26relation%3Dparent.parent&amp;container_width=0&amp;height=100&amp;href=http%3A%2F%2Fphongkhamtaman.com%2Fbai-viet%2Fve-chung-toi.html&amp;locale=vi_VN&amp;numposts=5&amp;sdk=joey&amp;version=v2.9&amp;width=" __idm_frm__="153" class="" style="border: none; visibility: visible; width: 100%; height: 0px;"></iframe></span></div>

                        script comment fb 
                        <script type="text/javascript">(function(d, s, id) {
                        var js, fjs = d.getElementsByTagName(s)[0];
                        if (d.getElementById(id)) return;
                        js = d.createElement(s); js.id = id;
                        js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&amp;version=v2.0";
                        fjs.parentNode.insertBefore(js, fjs);
                        }(document, 'script', 'facebook-jssdk'));
                        </script>
                        </div>
                        </div>
                        <div id="article">
                        <div class="info-title-related-article"><span>Tin cùng chuyên mục</span></div>
                        <div class="info-related-articles">
                        <ul>

                        <li class="item">							
                        <a href="bai-viet/so-do-to-chuc.html" title="Sơ đồ tổ chức">
                        <i class="fa fa-angle-double-right"></i> Sơ đồ tổ chức <span class="nd-info">(05-12-2018)</span>
                        </a>
                        </li>

                        <li class="item">							
                        <a href="bai-viet/tam-nhin-su-menh.html" title="Tầm nhìn - Sứ mệnh - Giá trị cốt lõi">
                        <i class="fa fa-angle-double-right"></i> Tầm nhìn - Sứ mệnh - Giá trị cốt lõi <span class="nd-info">(17-11-2018)</span>
                        </a>
                        </li>

                        </ul>
                        </div>
                    </div>
                </div>
               <!-- Điểm kết thúc -->
            </div>        
    </section>

  </main>