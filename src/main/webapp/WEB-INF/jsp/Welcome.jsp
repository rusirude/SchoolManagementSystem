<%--
 @Author : Rusiru De Silva
--%>
<div class="mdl-grid">
	<div class="mdl-cell mdl-cell--12-col-phone mdl-cell--8-col-tablet mdl-cell--8-col-desktop">
		<div>
			<img style="margin: 20px;height: auto;width: auto" src="resources/image/leafLogo.png">
		</div>
	</div>
	<div class="mdl-cell mdl-cell--12-col-phone mdl-cell--4-col-tablet mdl-cell--4-col-desktop">
		<div class="mdl-cell mdl-cell--12-col">
			<form class="mdl-cell mdl-cell--12-col">
				<div class="mdl-grid">
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
						<input id="f_username" name="username" type="text" class="mdl-textfield__input">
						<label class="mdl-textfield__label" for="f_username"><!--span><i class="medium material-icons prefix">perm_identity</i></span-->Username</label>
					</div>
				</div>
				<div class="mdl-grid">
					<div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label mdl-cell mdl-cell--12-col">
						<input id="f_password" name="password" type="password" class="mdl-textfield__input">
						<label class="mdl-textfield__label" for="f_password"><!--span><i class="medium material-icons prefix">lock_outline</i></span-->Password</label>
					</div>
				</div>
				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--12-col">
						<label class="mdl-checkbox mdl-js-checkbox" for="f_rememberMe">
							<input type="checkbox" id="f_rememberMe" class="mdl-checkbox__input" name="rememberMe" value="true">
							<span class="mdl-checkbox__label">Remember Me</span>
						</label>
					</div>
				</div>
				<div class="mdl-grid">
					<div class="mdl-cell mdl-cell--12-col-phone mdl-cell--5-col-tablet mdl-cell--5-col-desktop">
						<button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect  mdl-button--accent">Login</button>
					</div>
					<div class="mdl-cell mdl-cell--12-col-phone mdl-cell--5-col-tablet mdl-cell--5-col-desktop">
						<button type="button" onclick="location.href='forgotPassword'" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect  mdl-button--accent">Forgot Password</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

