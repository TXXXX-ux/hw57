<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>Личный кабинет</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .profile-header { background: linear-gradient(45deg, #007bff, #0056b3); color: white; padding: 20px; border-radius: 10px 10px 0 0; }
            .admin-section { border-left: 4px solid #dc3545; padding-left: 15px; }
            .user-section { border-left: 4px solid #17a2b8; padding-left: 15px; }
        </style>
    </head>
    <body class="bg-light">
        <#include "navbar.ftlh">
        <div class="container mt-5">
            <div class="card shadow-sm border-0">
                <div class="profile-header d-flex justify-content-between align-items-center">
                    <h4 class="mb-0">Личный кабинет: ${user.name}</h4>
                    <div class="d-flex gap-2">
                        <a href="/profile/edit" class="btn btn-light btn-sm">Редактировать</a>
                        <form action="/logout" method="post" class="m-0">
                            <button type="submit" class="btn btn-danger btn-sm">Выход</button>
                        </form>
                    </div>
                </div>

                <div class="card-body p-4">
                    <div class="row">
                        <div class="col-md-3 text-center border-end">
                            <img src="https://api.dicebear.com/7.x/bottts/svg?seed=${user.email}"
                            class="img-fluid rounded-circle mb-3 shadow-sm" style="width: 150px;" alt="Аватар">
                            <div>
                                <#if user.accountType == "EMPLOYER">
                                    <span class="badge bg-danger fs-6">Работодатель (Admin)</span>
                                <#else>
                                    <span class="badge bg-info fs-6 text-dark">Соискатель</span>
                                </#if>
                            </div>
                            <p class="text-muted mt-2 small">${user.email}</p>
                        </div>

                        <div class="col-md-9">
                            <#if user.accountType == "EMPLOYER">
                                <div class="admin-section mb-4">
                                    <h5 class="text-danger fw-bold">Управление платформой</h5>
                                    <div class="row g-2 mt-2">
                                        <div class="col-md-6">
                                            <a href="/profile" class="btn btn-outline-danger w-100 text-start">Мои вакансии</a>
                                        </div>
                                        <div class="col-md-6">
                                            <a href="/profile" class="btn btn-danger w-100 text-start">Создать вакансию</a>
                                        </div>
                                        <div class="col-md-6">
                                            <a href="/resumes" class="btn btn-outline-secondary w-100 text-start">Базовые резюме</a>
                                        </div>
                                    </div>
                                </div>
                            <#else>
                                <div class="user-section mb-4">
                                    <h5 class="text-info fw-bold">Моя карьера</h5>
                                    <div class="row g-2 mt-2">
                                            <div class="col-md-6">
                                                <a href="/resumes" class="btn btn-outline-info w-100 text-start">Мои резюме</a>
                                            </div>
                                            <div class="col-md-6">
                                                <a href="/profile" class="btn btn-info w-100 text-start text-white">Опубликовать резюме</a>
                                            </div>
                                            <div class="col-md-6">
                                                <a href="/vacancies" class="btn btn-outline-dark w-100 text-start">Искать вакансии</a>
                                            </div>
                                    </div>
                                </div>
                            </#if>

                            <hr>

                            <div class="about-section">
                                <h6 class="fw-bold">О себе:</h6>
                                <div class="p-3 bg-light rounded italic">
                                    ${user.about!"Тут пока пусто..."}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>