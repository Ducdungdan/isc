<#include "../../ultils/string-ultil.ftl"/>

<#macro menu>
	<#assign idMenu = generateId()>

	<div id="menu-${idMenu} kt_aside_menu_wrapper" class="kt-aside-menu-wrapper kt-grid__item kt-grid__item--fluid">
		<div id="kt_aside_menu" class="kt-aside-menu" data-ktmenu-vertical="1" data-ktmenu-scroll="1" data-ktmenu-dropdown-timeout="500">
			<ul class="kt-menu__nav ">
				<#nested />
			</ul>
		</div>
	</div>
<#--	kt-aside-menu--dropdown-->
</#macro>

<#macro groupMenuItem name="">
    <#assign idGroupMenuItem = generateId()>
	<#if name!="">
		<li id="group-menu-item-${idGroupMenuItem}" class="kt-menu__section ">
			<h4 class="kt-menu__section-text">${name}</h4>
			<i class="kt-menu__section-icon flaticon-more-v2"></i>
		</li>
	</#if>
    <#nested />
</#macro>

<#macro menuItem name="" iconSVG="" is_have_child=false is_new=false>
    <#assign idMenuItem = generateId()>

    <li id="menu-item-${idMenuItem}" class="kt-menu__item  kt-menu__item--submenu" aria-haspopup="true"
        data-ktmenu-submenu-toggle="hover">
        <a href="javascript:;" class="kt-menu__link kt-menu__toggle">
			<span class="kt-menu__link-icon">
				${iconSVG}
			</span>
            <span class="kt-menu__link-text">
				${name}
			</span>
            <#if is_have_child&&!is_new>
                <i class="kt-menu__ver-arrow la la-angle-right"></i>
            </#if>
			<#if is_new>
				<span class="kt-menu__link-badge"><span class="kt-badge kt-badge--danger kt-badge--inline">new</span></span>
			</#if>
        </a>
        <#if is_have_child>
            <div class="kt-menu__submenu "><span class="kt-menu__arrow"></span>
                <ul class="kt-menu__subnav">
                    <li class="kt-menu__item  kt-menu__item--parent" aria-haspopup="true">
						<span class="kt-menu__link">
							<span class="kt-menu__link-text">
								${name}
							</span>
						</span>
                    </li>
					<#nested />
                </ul>
            </div>
        </#if>
    </li>
</#macro>

<#macro subMenuItem name="" iconSVG="" is_new=false href="">
	<#assign idSubMenuItem = generateId()>

	<li id="sub-menu-item-${idSubMenuItem}" class="kt-menu__item  kt-menu__item--submenu" aria-haspopup="true"
		data-ktmenu-submenu-toggle="hover">
		<a href="<#if href!="">${href}<#else>javascript:;</#if>" class="kt-menu__link kt-menu__toggle">
			<#if iconSVG!="">
				<span class="kt-menu__link-icon">
					${iconSVG}
				</span>
			<#else>
				<i class="kt-menu__link-bullet kt-menu__link-bullet--line"><span></span></i>
			</#if>
			<span class="kt-menu__link-text">${name}</span>

			<#if is_new>
				<span class="kt-menu__link-badge">
					<span class="kt-badge kt-badge--danger kt-badge--inline">new</span>
				</span>
			</#if>
		</a>
	</li>
</#macro>

