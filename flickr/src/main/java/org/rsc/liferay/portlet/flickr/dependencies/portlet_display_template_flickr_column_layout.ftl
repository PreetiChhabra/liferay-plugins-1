<#if entries?has_content>
    <ul>
        <#list entries as photo>
    		<li class="flickr-photo">
    			<a href="${photo.getUrl()}" target="blank" title="${photo.getTitle()}"> 
    				<img src="${photo.getSmall320Url()}" alt="${photo.getTitle()}"/>
    			</a>
    		</li>
        </#list>
    </ul>
</#if>