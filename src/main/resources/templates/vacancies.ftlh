<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Список вакансий</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body class="bg-light">
        <#include "navbar.ftlh">
        <div class="container mt-4">
            <h2 class="mb-4 text-center">Актуальные вакансии</h2>

            <div class="row">
                <#if vacancies?? && vacancies?size gt 0>
                    <#list vacancies as vacancy>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="card h-100 shadow-sm">
                                <div class="card-body">
                                    <h5 class="card-title text-primary">${vacancy.title}</h5>
                                    <p class="card-text text-truncate" style="max-height: 100px;">
                                        ${vacancy.description!"Описание отсутствует"}
                                    </p>
                                    <p class="fw-bold text-success">${vacancy.salary!0} сом</p>
                                </div>
                                <div class="card-footer bg-transparent border-top-0 pb-3">
                                    <a href="#" class="btn btn-primary w-100">Откликнуться</a>
                                </div>
                            </div>
                        </div>
                    </#list>
                <#else>
                    <div class="col-12 text-center">
                        <p class="text-muted">К сожалению, вакансий пока нет.</p>
                    </div>
                </#if>
            </div>
        </div>
    </body>
</html>