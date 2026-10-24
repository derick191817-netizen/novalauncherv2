# Changelog
Formato: [Keep a Changelog](https://keepachangelog.com/pt-BR/1.1.0/). Versionamento semântico.

## [Unreleased]
### Added
- GitHub Actions (`android.yml`): compila o APK debug e roda os testes na nuvem; permite compilar só pelo celular.
- Gaveta: índice A–Z lateral (toque/arraste, com vibração) quando há mais de 30 apps.
- Perfil de uso filtra a gaveta (`ProfileFilter`): Trabalho = apps do perfil de trabalho, Games = jogos; com fallback para todos.
- Pastas da home podem ser renomeadas (`TextInputDialog`, `ManageHomeLayoutUseCase.renameFolder`).
- Home já nasce com apps comuns (galeria, calendário, relógio, Play Store, Maps…); dock com galeria e notas (até 7).
- Modo de edição: botão "Ajustes" e "Restaurar widgets (N)".
- Drag-and-drop na home (flag `dragAndDrop`, experimental) com `ManageHomeLayoutUseCase.moveItem` e `HomeLayout.canPlace`.
- Ícones temáticos Material You (flag `themedIcons`, Android 13+) via `ThemedIconProvider`.
- Backup inclui os widgets (providers) e a restauração é feita pela UI; backups antigos continuam válidos.
- `AppInfo.iconCacheKey` (extensão); cache de ícones usa a chave.
- Modo Economia reduz pela metade o cache de ícones em memória (`freezeOffscreenIcons` agora tem efeito).
- Acessibilidade: `contentDescription` nos apps (TalkBack no dock) e vibração no toque longo.
- "Definir como padrão" abre direto o diálogo `RoleManager.ROLE_HOME` (Android 10+).
- Testes: `HomeLayoutEditTest`, `ManageHomeLayoutEditTest`, `ProfileFilterTest`, `UniversalSearchUseCaseTest`, `AppInfoExtTest`, `HomeLayoutJsonTest`, `HomeViewModelEditTest`.
### Fixed
- Toque duplo (bloquear) e toque longo (editar) nunca disparavam: o pager capturava os toques e o fundo ficava atrás dele. Agora o fundo fica dentro de cada página.
- Itens da home "sumiam" ao diminuir linhas/colunas: `HomeLayout.reflow` os traz de volta.
- O layout era regravado em disco mesmo sem mudança.
- O dock padrão nunca escolhe a cópia do perfil de trabalho.
### Changed
- `ManageHomeLayoutUseCase.seed(...)` ganhou `rows`/`columns` com default (compatível).
### Merged from the other session (ideas only, reimplemented)
- `ProfileFilter` (com PERSONAL = todos), `TextInputDialog`, ordem/papéis do dock. Não mesclado: `LayoutOps`, `LayoutRepository` e `AppActionsRepository` (arquitetura diferente).
### Fixed
- `:app`: `androidResources.localeFilters` não existe no AGP 8.5.2; trocado por `resourceConfigurations`.
- `:app`: build `release` sem keystore configurado não quebra mais a configuração (sai sem assinatura).
- `:core:data`: `callbackFlow<Boolean>` explícito em `LauncherAppsDataSource.observe()`.
- `:feature:home`, `:feature:drawer`: dependência `activity-compose` (BackHandler) ausente.
