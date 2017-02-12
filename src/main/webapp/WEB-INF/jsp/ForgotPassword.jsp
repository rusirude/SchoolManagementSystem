<%--
@Author : Rusiru De Silva
--%>
<div class="mdl-grid">
	<div class="mdl-cell mdl-cell--1-col-phone mdl-cell--3-col-tablet mdl-cell--3-col-desktop">
	</div>
	<div class="mdl-cell mdl-cell--12-col-phone mdl-cell--6-col-tablet mdl-cell--6-col-desktop">
		<div class="col s12 m12 l12 z-depth-3" style="margin-right: 20px;margin-top: 100px">
			<form class="col s12 m12 l12">
				<div class="row">
					<div class="input-field col s12">
					  <i class="medium material-icons prefix">perm_identity</i>
					  <input id="f_username" name="username" type="text" class="validate" placeholder="Username" onblur="checkUserName(this.value)">
					</div>
				</div>
				<div id="f_forgotPasswordOption" class="row" style="display:none">
					<div class="input-field col s12">
						<p>
							<input id="f_forgotPassRecoverType_1" type="radio" name="forgotPassRecoverType" value="quactionType">
							<label for="f_forgotPassRecoverType_1">My Security Questions</label>
						</p>
						<p>
							<input id="f_forgotPassRecoverType_2" type="radio" name="forgotPassRecoverType" value="requsetByAdminType">
							<label for="f_forgotPassRecoverType_2">Request By Administrator</label>
						</p>
					</div>
				</div>
				<div id="f_quactionTypeSection" class="row" style="display:none">

				</div>
				<div id="f_requsetByAdminTypeSection" class="row" style="display:none">
					<div class="input-field col s12">
						<i class="medium material-icons prefix">perm_identity</i>
						<input id="f_mobileNo" name="mobileNo" type="text" class="validate" placeholder="Mobile Phone Number">
					</div>
				</div>
				<div class="row">
					<div class="col s12 m5 l5">
						<button type="button" class="btn waves-effect waves-teal green accent-4">Reset</button>
					</div>
					<div class="col s12 m2 l2"><br></div>
					<div class="col s12 m5 l5">
						<button type="button" onclick="location.href='welcome'" class="btn waves-effect waves-teal green accent-4">Back</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="mdl-cell mdl-cell--1-col-phone mdl-cell--3-col-tablet mdl-cell--3-col-desktop">
	</div>
</div>

<script type="text/javascript" src="resources/js/ForgotPassword.js"></script>
