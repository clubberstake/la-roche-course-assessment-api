﻿using System.Web;
using System.Web.Mvc;

namespace la_roche_course_assessment_api
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}